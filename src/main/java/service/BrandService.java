package service;

import mapper.BrandMapper;
import pojo.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandService {
    static BrandMapper brandMapper;
    public List<Brand> selectAll(){
        brandMapper=util.getSession.getBrandMapper();
        List<Brand> brands=new ArrayList<>();
        brands=brandMapper.selectAll();
        util.getSession.closeSession();
        return brands;
    }

    public void Insert(Brand brand){
        brandMapper=util.getSession.getBrandMapper();
        brandMapper.Insert(brand);
        util.getSession.closeSession();
    }

    public void Update(Brand brand){
        brandMapper=util.getSession.getBrandMapper();
        brandMapper.Update(brand);
        util.getSession.closeSession();
    }

    public void DeleteById(int id){
        brandMapper=util.getSession.getBrandMapper();
        brandMapper.DeleteById(id);
        util.getSession.closeSession();
    }

    public Brand  selectById(int id){
        brandMapper=util.getSession.getBrandMapper();
        Brand brand=brandMapper.selectById(id);
        util.getSession.closeSession();
        return brand;
    }
}
