package dev.kitnet.documentarapi.rest.dto;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO<T> {

    private List<T> data;
    private Integer number;
    private Integer size;
    private Integer totalPages;
    private Long totalElements;

    public static <T> PageDTO<T> fromJpaPage(Page<T> page) {
        PageDTO<T> dto = new PageDTO<>();
        BeanUtils.copyProperties(page, dto);
        dto.setData(page.getContent());
        return dto;
    }

    public static <T> PageDTO<T> createPageWithDTOList(List<T> list, Object page) {
        PageDTO<T> dto = new PageDTO<>();
        BeanUtils.copyProperties(page, dto);
        dto.setData(list);
        return dto;
    }
}
