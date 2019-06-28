package com.impurity.twitchwebintegrator.osrs.controller;

import com.impurity.twitchwebintegrator.osrs.controller.response.OsrsItemResponse;
import com.impurity.twitchwebintegrator.osrs.controller.response.OsrsPlayerResponse;
import com.impurity.twitchwebintegrator.osrs.service.OsrsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author tmk2003
 */
@Api(value = "Osrs API endpoints", tags = {"Osrs"})
@CrossOrigin(origins = {"https://tmk2003.github.io", "http://localhost:4200"}, maxAge = 3600)
@RequestMapping("/osrs/v1")
@RestController
public class OsrsController {

    @Autowired
    private OsrsService osrsService;

    @ApiOperation(value = "Returns Osrs player")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs player was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs player was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/players/{playerName}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public OsrsPlayerResponse getPlayer(
            @PathVariable("playerName") String playerName
    ) {
        OsrsPlayerResponse osrsPlayerResponse = new OsrsPlayerResponse();
        osrsPlayerResponse.setPlayer(osrsService.getPlayer(playerName));
        return osrsPlayerResponse;
    }

    @ApiOperation(value = "Returns Osrs item")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/items/{itemId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public OsrsItemResponse getPlayer(
            @PathVariable("itemId") Long itemId
    ) {
        OsrsItemResponse osrsItemResponse = new OsrsItemResponse();
        osrsItemResponse.setItem(osrsService.getItem(itemId));
        return osrsItemResponse;
    }
}