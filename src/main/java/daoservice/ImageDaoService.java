package daoservice;

import dao.DataBase;
import entity.Image;

public class ImageDaoService implements ImageService {
    public ImageDaoService(DataBase dataBase) {
    }

    @Override
    public Image findByEmployeeId(int employeeId) {
        return null;
    }
}
