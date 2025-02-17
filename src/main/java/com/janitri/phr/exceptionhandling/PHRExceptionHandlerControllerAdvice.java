package com.janitri.phr.exceptionhandling;

import com.janitri.phr.exception.ExceptionResponse;
import com.janitri.phr.exception.PatientNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Controller Advice class which is responsible to handle all the exception for this patient in a centralized place
 */
@ControllerAdvice
public class PHRExceptionHandlerControllerAdvice {

    /**
     * This method will handle the patientNotFoundException/status 404 ,
     * whenever this exception has been thrown by any controller method it will come here
     * to combine the exception and return a meaning full error message to the caller along with the calling method name
     *{
     *     "errorMessage": "patient not found",
     *     "requestedURI": "/patient/2"
     * }
     * @param patientNotFoundException
     * @param httpServletRequest
     *
     * @return response body (ExceptionResponse )
     */

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handlepatientNotFound(final PatientNotFoundException patientNotFoundException,
                                                                 final HttpServletRequest httpServletRequest) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(patientNotFoundException.getMessage());
        error.callerURL(httpServletRequest.getRequestURI());

        return error;
    }

    /**
     * This will handle the input dto field validation error usecases and combine those in a single map and return the same
     *{
     *     "errorMessage": "{name=Name is mandatory, description=Description is mandatory}",
     *     "requestedURI": "/patient"
     * }
     * @param methodArgumentNotValidException
     * @param httpServletRequest
     * @return response body (ExceptionResponse )
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handleValidationExceptions1(final MethodArgumentNotValidException methodArgumentNotValidException,
                                                                  final HttpServletRequest httpServletRequest) {
        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(errors.toString());
        error.callerURL(httpServletRequest.getRequestURI());

        return error;
    }

    /**
     * This method will handle  any Intern exception and /status 500 ,
     * and will throw patientManagemnetException
     * @param patientNotFoundException
     * @param httpServletRequest
     *
     * @return response body (ExceptionResponse )
     */

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleInternalServerFound(final PatientNotFoundException patientNotFoundException,
                                                                 final HttpServletRequest httpServletRequest) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(patientNotFoundException.getMessage());
        error.callerURL(httpServletRequest.getRequestURI());

        return error;
    }

}
