package org.example.swaqqerapi_study.feed;

import lombok.RequiredArgsConstructor;
import org.example.swaqqerapi_study.feed.model.Feed;
import org.example.swaqqerapi_study.feed.model.FeedDto;
import org.example.swaqqerapi_study.feed.model.FeedImage;
import org.example.swaqqerapi_study.user.model.AuthUserDetails;
import org.example.swaqqerapi_study.util.UploadUtil;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FeedSerivce {
    private final FeedRepository feedRepository;
    private final FeedImageRespository feedImageRespository;
    private final UploadUtil uploadUtil;

    public List<FeedDto.ListRes> list(@AuthenticationPrincipal AuthUserDetails user) {
        List<Feed> feedList = feedRepository.findAll();
        return feedList.stream().map((feed) -> FeedDto.ListRes.from(feed, user)).toList();
    }

    public List<FeedDto.ImageUploadRes> uploadImage(List<MultipartFile> images) {
        List<FeedDto.ImageUploadRes> result = new ArrayList<>();

        for(MultipartFile image : images) {
            String imageUrl = saveFile(image);
            FeedImage feedImage = FeedImage.builder()
                    .imageUrl(imageUrl)
                    .feed(null)
                    .build();
            feedImage = feedImageRespository.save(feedImage);

            result.add(FeedDto.ImageUploadRes.from(feedImage));
        }
        return result;

    }

    private String saveFile(MultipartFile file) {
        String uploadPath = uploadUtil.makeFolder();

        String filePath = uploadPath + File.separator + UUID.randomUUID() + "_" +file.getOriginalFilename();
        File saveFile = new File(filePath);
        try {
            file.transferTo(saveFile);
        }catch (Exception e) {
            e.printStackTrace();
        }


        return filePath;
    }
}
