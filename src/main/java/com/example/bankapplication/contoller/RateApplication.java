package com.example.bankapplication.contoller;

import com.example.bankapplication.entity.RateBA;
import com.example.bankapplication.service.RateBAService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vBank")
public class RateApplication {

    private final RateBAService rateBAService;

    /**
     * Метод предназначен для извлечения сущности RateBA по id
     *
     * @param id уникальный идентификатор сущности RateBA, по которому будет производиться поиск
     * @return  Метод возвращает объект типа ResponseEntity, который содержит сущность RateBA, если она была найдена по заданному ID, или возвращает статус "NOT FOUND" (404), если сущность с указанным ID не была найдена.
     */

    @GetMapping("/getRate")
    public ResponseEntity<RateBA> getRateBA(@RequestParam("id") Long id) {
        System.out.println(rateBAService.getRateBA(id));
        return ResponseEntity.ok(rateBAService.getRateBA(id));
    }

    /**
     * Метод предназначен для получения всех сущностей
     *
     * @return  Метод возвращает объект типа ResponseEntity, который содержит сущности RateBA
     */

    @GetMapping("/getRateAll")
    public ResponseEntity<List<RateBA>> getRateBAAll() {
        System.out.println(rateBAService.getAllRateBA());
        return ResponseEntity.ok(rateBAService.getAllRateBA());
    }

    /**
     * Метод служит для вызова меотда создания новой сущности
     *
     * @param rateBA которую необходимо создать
     * @return ResponseEntity со статусом NO CONTENT после успешного создания
     */

    @PostMapping("/createRate")
    public ResponseEntity<Void> createRateBA(@RequestBody RateBA rateBA) {
        System.out.println("create");
        rateBAService.createRateBA(rateBA);
        return ResponseEntity.noContent().build();
    }

    /**
     * Метод для вызова метода обновления сущности
     *
     * @param id Идентификатор объекта RateBA, который необходимо обновить
     * @param percent Новое процентное значение, которое необходимо установить
     * @return ResponseEntity содержащий обновленный объект RateBA в случае успеха, или статус НЕ НАЙДЕНО, если объект с указанным идентификатором не найден
     */

    @PatchMapping("/updateRate/{id}")
    public ResponseEntity<RateBA> updateRateBA(@PathVariable("id") Long id, @RequestParam Double percent) {
        System.out.println(rateBAService.updateRateBA(id, percent));
        return ResponseEntity.ok(rateBAService.updateRateBA(id, percent));
    }

    /**
     * Метод для вызова метода по удалению сущности по id
     *
     * @param id Идентификатор объекта RateBA, который необходимо удалить
     * @return ResponseEntity со статусом NO CONTENT после успешного удаления
     */
    @DeleteMapping("/deleteRate/{id}")
    public ResponseEntity<Void> deleteRateBA(@PathVariable("id") Long id) {
        System.out.println("delete");
        rateBAService.deleteRateBA(id);
        return ResponseEntity.noContent().build();
    }


}
