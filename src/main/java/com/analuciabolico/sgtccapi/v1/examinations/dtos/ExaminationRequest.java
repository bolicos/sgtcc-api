package com.analuciabolico.sgtccapi.v1.examinations.dtos;

import java.time.LocalDateTime;
import com.analuciabolico.sgtccapi.v1.examinations.enums.ExaminationTypeEnum;
import com.analuciabolico.sgtccapi.v1.examinations.model.Examination;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationRequest {

    private String title;
    private String presentation;
    private String textContent;
    private String textStructure;
    private String language;
    private String observation;
    private String relevance;
    private boolean approved;
    private Double note;
    private ExaminationTypeEnum type;
    private Long proposal;
    private Long teacher;


    public Examination convertToExamination() {
        return  Examination.builder()
                .id(null).title(this.title).presentation(this.presentation).textContent(this.textContent)
                .textStructure(this.textStructure).language(this.language).observation(this.observation)
                .relevance(this.relevance).approved(this.approved).note(this.note).type(this.type)
                .proposal(Proposal.builder().id(this.proposal).build()).createdAt(LocalDateTime.now())
                .teacher(Teacher.builder().id(this.teacher).build()).build();
    }
}
