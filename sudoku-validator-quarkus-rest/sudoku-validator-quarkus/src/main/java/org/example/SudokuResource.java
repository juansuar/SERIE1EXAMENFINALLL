package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Endpoint REST para validar tableros de Sudoku.
 */
@Path("/sudoku")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SudokuResource {

    private final SudokuValidator validator = new SudokuValidatorImpl();

    @POST
    @Path("/validar")
    public Response validarSudoku(char[][] board) {
        boolean valido = validator.isValidSudoku(board);
        return Response.ok().entity("{\"valido\":" + valido + "}").build();
    }
}