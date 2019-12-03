import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ViewDoctorsAppointmentComponent } from './view-doctors-appointment/view-doctors-appointment.component';
import { AddMedicineRequestComponent } from './add-medicine-request/add-medicine-request.component';
import { ViewDoctorComponent } from './view-doctor/view-doctor.component';
import { ViewMedicineComponent } from './view-medicine/view-medicine.component';
import { ViewStaffComponent } from './view-staff/view-staff.component';
import { AddStaffComponent } from './add-staff/add-staff.component';
import { HeaderComponent } from './header/header.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';
import { TodaysAppointmentComponent } from './todays-appointment/todays-appointment.component';
import { PatientPharmacyComponent } from './patient-pharmacy/patient-pharmacy.component';
import { LabtestRequestComponent } from './labtest-request/labtest-request.component';
import { ConsultationComponent } from './consultation/consultation.component';
import { ViewPatientHistoryComponent } from './view-patient-history/view-patient-history.component';
import { LoginComponent } from './login/login.component';
import { ViewStaffService } from './view-staff/view-staff.service';
import { HttpClientModule} from '@angular/common/http';
import { AddDoctorService } from './add-doctor/add-doctor.service';
import { AddStaffService } from './add-staff/add-staff.service';
import { ConsultationService } from './consultation/consultation.service';
import { ViewPatientService } from './view-patient/view-patient.service';
import { ViewMedicineService } from './view-medicine/view-medicine.service';
import { AddMedicineService } from './add-medicine/add-medicine.service';
import { LoginService } from './login/login.service';
import { ViewDoctorsAppointmentService } from './view-doctors-appointment/view-doctors-appointment.service';
import { ViewPatientHistoryService } from './view-patient-history/view-patient-history.service';
import { AddMedicineRequestService } from './add-medicine-request/add-medicine-request.service';
import { AddPatientService } from './add-patient/add-patient.service';
import { AuthGuard } from './guards/auth.guard';
import { AdminDashboardService } from './admin-dashboard/admin-dashboard.service';
import { LogoutService } from './logout.service';

@NgModule({
  declarations: [
    AppComponent,
    AdminDashboardComponent,
    ViewDoctorsAppointmentComponent,
    AddMedicineRequestComponent,
    ViewDoctorComponent,
    ViewMedicineComponent,
    ViewStaffComponent,
    AddStaffComponent,
    HeaderComponent,
    AddPatientComponent,
    AddMedicineComponent,
    AddDoctorComponent,
    ViewPatientComponent,
    TodaysAppointmentComponent,
    PatientPharmacyComponent,
    LabtestRequestComponent,
    ConsultationComponent,
    ViewPatientHistoryComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ViewStaffService,AddDoctorService,AddStaffService,ConsultationService,ViewPatientService,
    ViewMedicineService,LogoutService,AdminDashboardService,AddMedicineService,LoginService,ViewDoctorsAppointmentService,ViewPatientHistoryService,AddMedicineRequestService,AddPatientService,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }

