import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ViewPatientService } from './view-patient.service';
import { Admin } from '../admin';
import { FrontOffice } from '../frontOffice';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrls: ['./view-patient.component.scss']
})
export class ViewPatientComponent implements OnInit {
  patients: FrontOffice[];
  patient= new FrontOffice();
  regId:number;
  constructor(private route:ActivatedRoute, private logout: LogoutService,private router:Router,private _viewpatient:ViewPatientService) { }

  ngOnInit() {
 
    this.route.params.subscribe(params => this.getViewPatientByRegId(params['regId']));
    this.getPatients();
    
  
  }

  editPatient(regId:number):void{
    console.log(regId);
    this.router.navigate(['/updatePatient/'+regId]);
  } 


  getPatients(): void{
    this._viewpatient.AllPatients()
    .subscribe((patientData)=>{
      this.patients=patientData,
      console.log(patientData);
    }, (error) =>{
      console.log(error);
    });
  }

  //patient Search in FrontOffice
  searchPatient(search: string): void{
    if (search!=null){
    this._viewpatient.SearchPatient(search)
    .subscribe((patientData)=>{
      this.patients=patientData,
      console.log(patientData);
    }, (error) =>{
      console.log(error);
    });
  }else{
    this. getPatients();
  }
  }
  
  
  getViewPatientByRegId(regId: number)
  {
    this.regId=regId;
    console.log(regId);
    this._viewpatient.ViewPatientByRegId(regId).subscribe((patientData)=>{
      this.patient=patientData;
      console.log(patientData);
    },(error)=>{
      console.log(error);
    });
  }
  
  consult(regId:number):void{
    this.router.navigate(['Consultation/'+regId]);
  }
   openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
  }
  
  ViewPatient()
  {
    this.router.navigate(['/ViewPatient']);  
  } 
   AddPatient()
  {
    this.router.navigate(['/AddPatient']);  
  }
  TodaysApp()
  {
    this.router.navigate(['/TodaysApp']);  
  }
  Consultation()
  {
    this.router.navigate(['/Consultation']);  
  }
  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 

}
