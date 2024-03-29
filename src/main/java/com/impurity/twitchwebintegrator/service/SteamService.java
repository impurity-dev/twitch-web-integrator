package com.impurity.twitchwebintegrator.service;

import com.impurity.twitchwebintegrator.domain.steam.SteamLibrary;

/**
 * @author tmk2003
 */
public interface SteamService {

    /**
     * Get the steam users library
     *
     * @param steamProfileID - ID to grab the user library of
     * @return A steam users library
     */
    SteamLibrary getGameLibrary(String steamProfileID);

    /**
     * Get the steam users library amount
     *
     * @param steamProfileID - ID to grab the user library of
     * @return A steam users library amount
     */
    Long getGameLibraryAmount(String steamProfileID);
}
