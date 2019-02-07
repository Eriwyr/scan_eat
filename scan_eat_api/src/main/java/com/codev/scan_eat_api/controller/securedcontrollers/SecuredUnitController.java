package com.codev.scan_eat_api.controller.securedcontrollers;

import com.codev.scan_eat_api.entities.Unit;
import com.codev.scan_eat_api.exceptions.ExceptionGenerator;
import com.codev.scan_eat_api.exceptions.ScanEatException;
import com.codev.scan_eat_api.repository.UnitRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(value={"public/units", "units"}) //public/ingredient is only for testing
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class SecuredUnitController {

    private final UnitRepository unitRepository;

    @GetMapping("/find")
    ResponseEntity<Object> find(@RequestParam("id") final int unitId) throws ScanEatException {
        Optional<Unit> unitOpt = unitRepository.findById(unitId);
        if(!unitOpt.isPresent()) {
            ExceptionGenerator.unitNotFound(unitId);
        }
        return ResponseEntity.ok(unitOpt.get());
    }

    @GetMapping("/all")
    ResponseEntity<Object> find() throws ScanEatException {
        return ResponseEntity.ok(unitRepository.findAll());
    }

    @ExceptionHandler({ScanEatException.class})
    public ResponseEntity<Object> onScanEatException(HttpServletRequest req, ScanEatException ex) {
        return ex.getResponseEntity();
    }
}
