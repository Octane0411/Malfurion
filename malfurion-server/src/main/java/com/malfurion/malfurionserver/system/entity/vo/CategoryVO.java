package com.malfurion.malfurionserver.system.entity.vo;

import com.malfurion.malfurionserver.system.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVO {
    private long categoryId;

    private String categoryName;

    private List<CategoryVO> categoryChildren;
}
