package com.azati.study.springactuatordemo.component;

import com.azati.study.springactuatordemo.dto.request.MyItemCreateReqDto;
import com.azati.study.springactuatordemo.dto.request.MyItemUpdateReqDto;
import com.azati.study.springactuatordemo.entity.MyItem;
import com.azati.study.springactuatordemo.entity.MyItemStatus;
import com.azati.study.springactuatordemo.service.DateTimeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MyItemEntityUtils {

    DateTimeService dateTimeService;

    public MyItem createMyItem(MyItemCreateReqDto dto) {
        return new MyItem()
                .setNumber(dto.getNumber())
                .setName(dto.getName())
                .setStatus(MyItemStatus.CREATED)
                .setLastChangedDateTime(dateTimeService.getCurrentLocalDateTime());
    }

    public MyItem updateMyItem(MyItem item, MyItemUpdateReqDto dto) {
        return item
                .setNumber(dto.getNumber())
                .setName(dto.getName())
                .setStatus(MyItemStatus.UPDATED)
                .setLastChangedDateTime(dateTimeService.getCurrentLocalDateTime());
    }

    public MyItem prepareForClosingMyItem(MyItem item) {
        return item
                .setStatus(MyItemStatus.READY_TO_CLOSE)
                .setLastChangedDateTime(dateTimeService.getCurrentLocalDateTime());
    }

    public MyItem closeMyItem(MyItem item) {
        return item
                .setStatus(MyItemStatus.CLOSED)
                .setLastChangedDateTime(dateTimeService.getCurrentLocalDateTime());
    }
}
