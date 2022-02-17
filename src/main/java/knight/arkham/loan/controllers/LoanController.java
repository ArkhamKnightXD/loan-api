package knight.arkham.loan.controllers;

import io.swagger.v3.oas.annotations.Operation;
import knight.arkham.loan.entities.Loan;
import knight.arkham.loan.services.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @GetMapping("/loans")
    @Operation(summary = "Get All Loans", description = "Consigue la lista de todos los loans")
    public ResponseEntity<List<Loan>> getAllLoans() {

        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }


    @GetMapping("/loans/{loanId}")
    @Operation(summary = "Get A Loan By Id", description = "Retorna un prestamo con el id correspondiente")
    public ResponseEntity<Loan> getLoanById(@PathVariable long loanId) {

        var actualLoan = loanService.getLoanById(loanId);

        if (actualLoan != null)
            return new ResponseEntity<>(actualLoan, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping("/loans")
    @Operation(summary = "Save Loan", description = "Crear prestamo")
    public ResponseEntity<List<Loan>> saveLoan(@RequestBody Loan loanToSave) {

        var loans= loanService.saveLoan(loanToSave);

        return new ResponseEntity<>(loans, HttpStatus.OK);
    }


    @PutMapping("/loans")
    @Operation(summary = "Update Loan", description = "Actualiza el prestamo enviado")
    public ResponseEntity<List<Loan>> updateLoan(@RequestBody Loan updatedLoan) {

        var loans = loanService.updateLoan(updatedLoan);

        return new ResponseEntity<>(loans, HttpStatus.OK);
    }


    @DeleteMapping("/loans/{loanId}")
    @Operation(summary = "Delete A Loan By Id", description = "Elimina un prestamo con el id correspondiente")
    public ResponseEntity<List<Loan>> deleteLoanById(@PathVariable long loanId) {

        loanService.deleteLoanById(loanId);

        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }
}
