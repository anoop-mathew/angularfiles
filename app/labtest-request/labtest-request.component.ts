import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FrontOffice } from '../frontOffice';
import { LabtestRequestService } from './labtest-request.service';
import { Doctor } from '../doctor';
import { LogoutService } from '../logout.service';


@Component({
  selector: 'app-labtest-request',
  templateUrl: './labtest-request.component.html',
  styleUrls: ['./labtest-request.component.scss']
})
export class LabtestRequestComponent implements OnInit {

  constructor(private router:Router,private logout: LogoutService,private route:ActivatedRoute, private addPatReq:LabtestRequestService) { }
  dId:number;
  regId:number;
  labpress: Doctor[];
  patDet=new FrontOffice();
  prescrib=new Doctor();
  labDets:Doctor[];
  ngOnInit() {

    this.route.params.subscribe(params=>this.getIds(params['dId'],params['regId']))
    this.getPatient();
   this.getAllLabs();
   this.getLabPrescription();
  }

    

  getIds(dId:number,regId:number){
    this.dId=dId;
    this.regId=regId;
  }

  getPatient():void{
    this.addPatReq.getPatientDetails(this.regId)
    .subscribe((patData)=>{
      this.patDet=patData;
    },(error)=>{
      console.log(error);
    });
  }

  getAllLabs(): void{
    this.addPatReq.getAllLabs()
    .subscribe((medicineData)=>{
      this.labpress=medicineData,
      console.log(medicineData);
    }, (error) =>{
      console.log(error);
    });
  }
  
  addLabPrescription(){
    this.prescrib.regId=this.regId;
    this.prescrib.dId=this.dId;
    console.log(this.prescrib);
    this.addPatReq.addLabPrescrib(this.prescrib)
    .subscribe((response)=>{
      this.reset();
     this.getLabPrescription();
    },(error)=>{
      console.log(error);
    });
  }

  getLabPrescription(){
    this.addPatReq.getPrecDetails(this.dId,this.regId)
    .subscribe((preData)=>{
      this.labDets=preData
      console.log(this.labDets);
    },(error)=>{
      console.log(error);
    });
  }

  
  deleteLab(assignLabId: number){
    this.addPatReq.deleteLab(assignLabId)
      .subscribe((response)=>{
        console.log(response);
        this.getLabPrescription();
      }, (error)=>{
        console.log(error);
      });
  }

  reset(){
    this.prescrib.lName=undefined;
  
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
  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 
 

  Home()
  {
    this.router.navigate(['/ViewPatHis/'+this.dId+'/'+this.regId]);
  }
}
