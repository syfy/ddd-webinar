package org.vaadin.peholmst.samples.dddwebinar.ui.appointments;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.peholmst.samples.dddwebinar.ui.appointments.model.AppointmentViewModel;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

@SpringView(name = "appointment")
public class AppointmentView extends HorizontalLayout implements View {

    @Autowired
    AppointmentViewModel model;

    @Autowired
    DoctorSection doctorSection;

    @Autowired
    AppointmentSection appointmentSection;

    @Autowired
    PatientSection patientSection;

    @PostConstruct
    void init() {
        setSpacing(true);
        setMargin(true);
        setSizeFull();
        addComponent(patientSection);
        addComponent(appointmentSection);
        addComponent(doctorSection);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Long id = Long.valueOf(event.getParameters());
        model.initialize(id);
        // TODO add error handling
    }
}
