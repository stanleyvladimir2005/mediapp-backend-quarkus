package com.mitocode.repo;

import com.mitocode.model.FileMedia;
import org.springframework.stereotype.Repository;

@Repository
public interface IMediaFileRepo extends IGenericRepo<FileMedia, Integer> {
}