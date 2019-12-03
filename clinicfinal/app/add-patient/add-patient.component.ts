import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AddPatientService } from './add-patient.service';
import { FrontOffice } from '../frontOffice';
import { ViewPatientService } from '../view-patient/view-patient.service';
import { LogoutService } from '../logout.service';


@Component({
  selector: 'app-add-patient',
 templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.scss']
  
  //Example: {{regId}}
  
})
export class AddPatientComponent implements OnInit {

  patients: FrontOffice[];
  patientObj=new FrontOffice();


  constructor(private route: ActivatedRoute, private logout: LogoutService,private router:Router, private _patientService: AddPatientService) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.getPatientById(params['regId']));
    //this.getPatientById(this.patientObj.regId);
  }

  getPatientById(regId:number) {
    console.log(regId);
    this._patientService.getPatientById(regId)
    .subscribe((patientData)=>{
      this.patientObj= patientData;
      console.log(patientData);
    },(error)=>{
      console.log(error);
    });
    }
  updatePatient(regId:number): void{
    this._patientService.savePatient(this.patientObj)
    .subscribe((response)=>{
      this.ViewPatient();
      this.router.navigate(['/ViewPatient']);  
  
    },(error)=>{
      console.log(error);
    });
  }

   
  savePatient(): void {
    this._patientService.savePatient(this.patientObj)
  .subscribe((response)=>{
    console.log(response);
    this.reset();
    //this.savePatient();
    this.router.navigate(['/ViewPatient']);  
  },(error)=>{
    console.log(error);
  });
}



/*getAllPatients(): void{
  this. _viewPatient.AllPatients()
  .subscribe((patData) =>{
    this.patients=patData;
    this.getAllPatients();
    console.log(patData);
  },(error) =>{
    console.log(error);
 
});
}*/
private reset(){
  this.patientObj.pFName=null;
  this.patientObj.pLName=null;
  this.patientObj.pDOB=null;
  this.patientObj.pAddr=null;
  this.patientObj.pPhNo=null;
  this.patientObj.pGender=null;
  this.patientObj.pcreatedDate=null;
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
