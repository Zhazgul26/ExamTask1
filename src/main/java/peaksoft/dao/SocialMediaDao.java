package peaksoft.dao;


import peaksoft.entity.SocialMedia;

import java.util.List;

public interface SocialMediaDao {
    public void saveMedia(SocialMedia socialMedia);

    public SocialMedia getSocialMedia(Long id);

    public List<SocialMedia> getAllMedia();

    public void updateSocialMedia(Long id, SocialMedia socialMedia);

    public void deleteSocialMedia(Long id);

    public SocialMedia getSocialMediaByName(String name);

    public void assignPersonToMedia(Long id, Long mediaId);

}
