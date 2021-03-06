package org.shanoir.ng.importer;

import org.shanoir.ng.importer.model.ImportJob;
import org.shanoir.ng.shared.exception.RestServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-08-10T08:45:26.334Z")

@Api(value = "importer", description = "the importer API")
@RequestMapping("/importer")
public interface ImporterApi {

    @ApiOperation(value = "Upload files", notes = "Upload files", response = Void.class, tags={ "Upload files", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success returns file path", response = Void.class),
        @ApiResponse(code = 400, message = "Invalid input / Bad Request", response = Void.class),
        @ApiResponse(code = 409, message = "Already exists - conflict", response = Void.class),
        @ApiResponse(code = 200, message = "Unexpected Error", response = Error.class) })
    @RequestMapping(value = "/upload/",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    ResponseEntity<Void> uploadFiles(@ApiParam(value = "file detail") @RequestPart("files") MultipartFile[] files) throws RestServiceException;

    @ApiOperation(value = "Upload one DICOM .zip file", notes = "Upload DICOM .zip file", response = Void.class, tags={ "Upload one DICOM .zip file", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success returns file path", response = Void.class),
        @ApiResponse(code = 400, message = "Invalid input / Bad Request", response = Void.class),
        @ApiResponse(code = 409, message = "Already exists - conflict", response = Void.class),
        @ApiResponse(code = 200, message = "Unexpected Error", response = Error.class) })
    @RequestMapping(value = "/upload_dicom/",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    ResponseEntity<ImportJob> uploadDicomZipFile(@ApiParam(value = "file detail") @RequestPart("file") MultipartFile dicomZipFile) throws RestServiceException;
    
    @ApiOperation(value = "Start import job", notes = "Start import job", response = Void.class, tags={ "Start import job", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "import job started", response = Void.class),
        @ApiResponse(code = 400, message = "Invalid input / Bad Request", response = Void.class),
        @ApiResponse(code = 500, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/start_import_job/",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> startImportJob(@ApiParam(value = "ImportJob", required=true) @RequestBody ImportJob importJob) throws RestServiceException;
}
