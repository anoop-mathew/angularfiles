import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AddMedicineRequestService } from './add-medicine-request.service';
import { FrontOffice } from '../frontOffice';
import { Doctor } from '../doctor';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-add-medicine-request',
  templateUrl: './add-medicine-request.component.html',
  styleUrls: ['./add-medicine-request.component.scss']
})
export class AddMedicineRequestComponent implements OnInit {

  constructor(private router:Router, private logout: LogoutService, private route:ActivatedRoute,private addMedReq:AddMedicineRequestService) { }
  dId:number;
  regId:number;
  patDet=new FrontOffice();
  medpress: Doctor[];
  prescrib=new Doctor();
  precDets:Doctor[];

  ngOnInit() {
    this.route.params.subscribe(params=>this.getIds(params['dId'],params['regId']))
    this.getPatient();
   this.getAllMedicines();
   this.getPrescription();
  }

  getIds(dId:number,regId:number){
    this.dId=dId;
    this.regId=regId;
  }
  getAllMedicines(): void{
    this.addMedReq.getAllMedicines()
    .subscribe((medicineData)=>{
      this.medpress=medicineData,
      console.log(medicineData);
    }, (error) =>{
      console.log(error);
    });
  }
  addPrescription(){
    this.prescrib.regId=this.regId;
    this.prescrib.dId=this.dId;
    console.log(this.prescrib);
    this.addMedReq.addPrescrib(this.prescrib)
    .subscribe((response)=>{
      this.reset();
     this.getPrescription();
    },(error)=>{
      console.log(error);
    });
  }
  getPrescription(){
    this.addMedReq.getPrecDetails(this.dId,this.regId)
    .subscribe((preData)=>{
      this.precDets=preData
    },(error)=>{
      console.log(error);
    });
  }
  getPatient():void{
    this.addMedReq.getPatientDetails(this.regId)
    .subscribe((patData)=>{
      this.patDet=patData;
    },(error)=>{
      console.log(error);
    });
  }
  reset(){
    this.prescrib.medName=undefined;
   this.prescrib.medDays=undefined;
    this.prescrib.medFreq=undefined;
  }


  
  deleteMed(prescId: string){
    this.addMedReq.deleteMed(prescId)
      .subscribe((response)=>{
        console.log(response);
        this. getPrescription();
      }, (error)=>{
        console.log(error);
      });
  }


  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
  }

  ViewDocApp()
  {
    this.router.navigate(['/ViewDocApp']);  
  }

  backHis()
  {
    this.router.navigate(['/ViewPatHis']);  
  }
  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 

  Home()
  {
    this.router.navigate(['/ViewPatHis/'+this.dId+'/'+this.regId]);
  }

}
