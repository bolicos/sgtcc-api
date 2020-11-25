package com.analuciabolico.sgtccapi.v1.core.services.interfaces;

import java.io.ByteArrayInputStream;
import java.util.List;
import com.analuciabolico.sgtccapi.v1.classes.dtos.StudentClassResponse;

public interface IGeneratedReportPdf {
    ByteArrayInputStream tableClassesStudent(List<StudentClassResponse> list);
}
