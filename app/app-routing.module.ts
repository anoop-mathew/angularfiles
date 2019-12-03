import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AddMedicineRequestComponent } from './add-medicine-request/add-medicine-request.component';
import { ViewStaffComponent } from './view-staff/view-staff.component';
import { AddStaffComponent } from './add-staff/add-staff.component';
import { ViewDoctorComponent } from './view-doctor/view-doctor.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { ViewMedicineComponent } from './view-medicine/view-medicine.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { TodaysAppointmentComponent } from './todays-appointment/todays-appointment.component';
import { ViewDoctorsAppointmentComponent } from './view-doctors-appointment/view-doctors-appointment.component';
import { LoginComponent } from './login/login.component';
import { ViewPatientHistoryComponent } from './view-patient-history/view-patient-history.component';
import { LabtestRequestComponent } from './labtest-request/labtest-request.component';
import { ConsultationComponent } from './consultation/consultation.component';
import { AuthGuard } from './guards/auth.guard';


const routes: Routes = [ 
  {path: '', redirectTo: 'Login', pathMatch: 'full'},
  {path:'Login', component:LoginComponent},
  {path:'Admin', component:AdminDashboardComponent, canActivate : [AuthGuard]},
  {path:'ViewStaff', component:ViewStaffComponent, canActivate : [AuthGuard]},
  {path:'AddStaff', component:AddStaffComponent, canActivate : [AuthGuard]},
  {path:'ViewDoctor', component:ViewDoctorComponent, canActivate : [AuthGuard]},
  {path:'AddDoctor', component:AddDoctorComponent, canActivate : [AuthGuard]},
  {path:'ViewMedicine', component:ViewMedicineComponent, canActivate : [AuthGuard]},
  {path:'AddMedicine', component:AddMedicineComponent, canActivate : [AuthGuard]},
  {path:'ViewPatient', component:ViewPatientComponent, canActivate : [AuthGuard]},
  {path:'ViewPatient/:regId', component:ViewPatientComponent, canActivate : [AuthGuard]},
  {path:'AddPatient', component:AddPatientComponent, canActivate : [AuthGuard]},
  {path:'updatePatient/:regId', component:AddPatientComponent, canActivate : [AuthGuard]},
  {path:'TodaysApp', component:TodaysAppointmentComponent, canActivate : [AuthGuard]},
  {path:'ViewDocApp', component:ViewDoctorsAppointmentComponent, canActivate : [AuthGuard]},
  {path:'ViewPatHis/:dId/:regId', component:ViewPatientHistoryComponent, canActivate : [AuthGuard]},
  {path:'labRequest/:dId/:regId', component:LabtestRequestComponent, canActivate : [AuthGuard]},
  {path:'MedRequest/:dId/:regId', component:AddMedicineRequestComponent, canActivate : [AuthGuard]},
  {path:'Logout', component:LoginComponent, canActivate : [AuthGuard]},
  {path:'Consultation/:regId',component:ConsultationComponent, canActivate : [AuthGuard]},
  {path:'updateMedicine/:medId', component:AddMedicineComponent, canActivate : [AuthGuard]},
  {path:'editDoc/:sId', component:AddDoctorComponent, canActivate : [AuthGuard]},
  {path:'AdminHome/:sId', component:AdminDashboardComponent, canActivate : [AuthGuard]},
  {path:'frontHome/:sId', component:TodaysAppointmentComponent, canActivate : [AuthGuard]},
  {path:'docHome/:dId', component:ViewDoctorsAppointmentComponent, canActivate : [AuthGuard]},
  {path:'editStaff/:sId', component:AddStaffComponent, canActivate : [AuthGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
