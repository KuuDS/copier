package me.kuuds.copier.api;

import javassist.NotFoundException;
import me.kuuds.copier.domain.BlobData;
import me.kuuds.copier.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * Rest API
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/b")
public class DataApi extends BaseApi {

    @PutMapping("")
    public BlobData createData() {
        BlobData blobData = new BlobData();
        return blobDataRepository.save(blobData);
    }

    @Transactional
    @PostMapping("/{dataId}")
    public void appendData(@PathVariable("dataId") int dataId, String data) throws NotFoundException {
        BlobData blobData = blobDataRepository.findByUserIdAndBlobId(getUserId(), dataId)
                .orElseThrow(() -> new NotFoundException("can't found blob"));
        blobData.setData(blobData.getData() + data);
        blobDataRepository.save(blobData);
    }


    @GetMapping("")
    public List<BlobData> getDataList() {
        Pageable pageable = Pageable.unpaged();
        return blobDataRepository.findAllByUserId(getUserId(), pageable).toList();
    }

    @GetMapping("/{dataId}")
    public BlobData getData(@PathVariable("dataId") int dataId) throws NotFoundException {
        User user = getUser();
        return relationRepository.findWithUserIdAndBlobId(user.getId(), dataId)
                .map(relation -> blobDataRepository.findById(relation.getUserId()))
                .map(Optional::get)
                .orElseThrow(() -> new NotFoundException("can't found blob"));
    }

}
