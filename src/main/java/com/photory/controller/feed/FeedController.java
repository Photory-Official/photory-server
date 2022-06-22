package com.photory.controller.feed;

import com.photory.common.dto.ApiResponse;
import com.photory.config.resolver.UserEmail;
import com.photory.controller.feed.dto.request.DeleteFeedRequestDto;
import com.photory.controller.feed.dto.request.ModifyFeedRequestDto;
import com.photory.controller.feed.dto.response.ModifyFeedResponse;
import com.photory.controller.feed.dto.response.GetFeedResponse;
import com.photory.service.feed.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/feed")
public class FeedController {

    private final FeedService feedService;

    @PostMapping
    public ApiResponse<String> createFeed(
            @RequestPart List<MultipartFile> images,
            @RequestParam Long roomId,
            @RequestParam @NotBlank(message = "제목을 입력해야합니다.") String title,
            @RequestParam @NotNull(message = "내용은 null 값일 수 없습니다.") String content,
            @UserEmail String userEmail
    ) {
        feedService.createFeed(userEmail, images, roomId, title, content);
        return ApiResponse.SUCCESS;
    }

    @GetMapping("/{feedId}")
    public ApiResponse<GetFeedResponse> getFeed(@PathVariable("feedId") @Valid Long feedId, @UserEmail String userEmail) {
        GetFeedResponse getFeedResponse = feedService.getFeed(userEmail, feedId);
        return ApiResponse.success(getFeedResponse);
    }

    @PutMapping
    public ApiResponse<ModifyFeedResponse> modifyFeed(@RequestBody @Valid ModifyFeedRequestDto modifyFeedRequestDto, @UserEmail String userEmail) {
        ModifyFeedResponse modifyFeedResponse = feedService.modifyFeed(userEmail, modifyFeedRequestDto);
        return ApiResponse.success(modifyFeedResponse);
    }

    @DeleteMapping
    public ApiResponse<String> deleteFeed(@RequestBody @Valid DeleteFeedRequestDto deleteFeedRequestDto, @UserEmail String userEmail) {
        feedService.deleteFeed(userEmail, deleteFeedRequestDto);
        return ApiResponse.SUCCESS;
    }
}