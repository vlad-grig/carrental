package com.sda.carrentalservice.restcontroller;

import com.sda.carrentalservice.dto.EmployeeDTO;
import com.sda.carrentalservice.dto.RentalOfficeDTO;
import com.sda.carrentalservice.entity.Employee;
import com.sda.carrentalservice.entity.RentalOffice;
import com.sda.carrentalservice.service.RentalOfficeService;
import com.sda.carrentalservice.transformer.RentalOfficeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/rentaloffice")
public class RentalOfficeController {

    private final RentalOfficeService rentalOfficeService;
    private final RentalOfficeTransformer rentalOfficeTransformer;

    @Autowired
    public RentalOfficeController(RentalOfficeService rentalOfficeService, RentalOfficeTransformer rentalOfficeTransformer) {
        this.rentalOfficeService = rentalOfficeService;
        this.rentalOfficeTransformer = rentalOfficeTransformer;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RentalOfficeDTO> findRentalOfficeById(@PathVariable("id") Long id) {
        RentalOffice rentalOffice = rentalOfficeService.findRentalOfficeById(id);
        RentalOfficeDTO rentalOfficeDTO = rentalOfficeTransformer.transformFromEntityToDTO(rentalOffice);
        return ResponseEntity.ok(rentalOfficeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RentalOfficeDTO> deleteRentalOfficeById(@PathVariable("id") Long id) {
        rentalOfficeService.deleteRentalOfficeById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<RentalOfficeDTO> createRentalOffice(@RequestBody RentalOfficeDTO rentalOfficeDTO) {
        RentalOffice rentalOffice = rentalOfficeTransformer.transformFromDTOToEntity(rentalOfficeDTO);
        RentalOffice savedRentalOffice = rentalOfficeService.saveRentalOffice(rentalOffice);
        RentalOfficeDTO savedRentalOfficeDTO = rentalOfficeTransformer.transformFromEntityToDTO(savedRentalOffice);
        return ResponseEntity.ok(savedRentalOfficeDTO);
    }

    @PutMapping
    public ResponseEntity<RentalOfficeDTO> updateRentalOffice(@RequestBody RentalOfficeDTO rentalOfficeDTO) {
        RentalOffice rentalOffice = rentalOfficeTransformer.transformFromDTOToEntity(rentalOfficeDTO);
        RentalOffice savedRentalOffice = rentalOfficeService.saveRentalOffice(rentalOffice);
        RentalOfficeDTO savedRentalOfficeDTO = rentalOfficeTransformer.transformFromEntityToDTO(savedRentalOffice);
        return ResponseEntity.ok(savedRentalOfficeDTO);
    }
}
