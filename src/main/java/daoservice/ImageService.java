package daoservice;

import entity.Image;

public interface ImageService {
    Image findByEmployeeId(int employeeId);
}
