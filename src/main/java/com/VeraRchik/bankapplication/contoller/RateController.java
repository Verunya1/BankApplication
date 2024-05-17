package com.VeraRchik.bankapplication.contoller;

import com.VeraRchik.bankapplication.dto.RateBADto;
import com.VeraRchik.bankapplication.entity.RateBA;
import com.VeraRchik.bankapplication.mapper.RateBAMapperInterface;
import com.VeraRchik.bankapplication.service.RateBAService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/vBank")
@CrossOrigin(origins = "http://localhost:3000")
 //todo создавать удалять обновлять и редактировать мог только админ, а предложения могут видеть все
public class RateController {

    private final RateBAService rateBAService;

    private final RateBAMapperInterface rateBAMapper;


    /**
     * Метод предназначен для извлечения сущности RateBADto по id
     *
     * @param id уникальный идентификатор сущности RateBA, по которому будет производиться поиск
     * @return  Метод возвращает объект типа ResponseEntity, который содержит сущность RateBADto, если она была найдена по заданному ID, или возвращает статус "NOT FOUND" (404), если сущность с указанным ID не была найдена.
     */

    @GetMapping("/getRate/{id}")
//    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<RateBADto> getRateBA(@PathVariable("id") Long id) {
        log.info("Сущность с id={},{}",id, rateBAService.getRateBA(id));
        RateBA rateBA = rateBAService.getRateBA(id);
        RateBADto rateBADto = rateBAMapper.rateToDto(rateBA);
        return ResponseEntity.ok(rateBADto);
    }

    /**
     * Метод предназначен для получения всех сущностей RateBADto
     *
     * @return  Метод возвращает объект типа ResponseEntity, который содержит список объектов RateBADto с информацией о всех сущностях,
     * если они найдены, или пустым списком, если сущностей нет.
     */

    @GetMapping("/getRateAll")
//    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<List<RateBADto>> getRateBAAll() {
        log.info("Получение всех сущностей {}", rateBAService.getAllRateBA());
        List<RateBA> rateBAList = rateBAService.getAllRateBA();
        List<RateBADto> rateBADtoList = rateBAList.stream()
                .map(rateBAMapper::rateToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(rateBADtoList);
    }

    /**
     * Метод служит для вызова меотда создания новой сущности
     *
     * @param rateBA которую необходимо создать
     * @return ResponseEntity со статусом NO CONTENT после успешного создания
     */

    @PostMapping("/createRate")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> createRateBA(@RequestBody RateBA rateBA) {
        rateBAService.createRateBA(rateBA);
        log.info("Создана сущность {}", rateBA );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Метод для вызова метода обновления сущности
     *
     * @param id Идентификатор объекта RateBA, который необходимо обновить
     * @param percent Новое процентное значение, которое необходимо установить
     * @return ResponseEntity содержащий обновленный объект RateBADto в случае успеха, или статус НЕ НАЙДЕНО, если объект с указанным идентификатором не найден
     */

    @PatchMapping("/updateRate/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<RateBADto> updateRateBA(@PathVariable("id") Long id, @RequestParam Double percent) {
        log.info("Изменен процент обслуживания с {} на {}", rateBAService.getRateBA(id).getPercentService(), percent);
        log.info("Тариф = {}", rateBAService.getRateBA(id).getPercentService());
        RateBA updatedRateBA = rateBAService.updateRateBA(id, percent);
        RateBADto updatedRateBADto = rateBAMapper.rateToDto(updatedRateBA);
        return ResponseEntity.ok(updatedRateBADto);
    }

    /**
     * Метод для вызова метода по удалению сущности по id
     *
     * @param id Идентификатор объекта RateBADto, который необходимо удалить
     * @return ResponseEntity со статусом NO CONTENT после успешного удаления
     */
    @DeleteMapping("/deleteRate/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteRateBA(@PathVariable("id") Long id) {
        log.info("Удален тариф {}", rateBAService.getRateBA(id));
        log.info("Удален тариф {}", id);
        rateBAService.deleteRateBA(id);
        return ResponseEntity.noContent().build();
    }

}
