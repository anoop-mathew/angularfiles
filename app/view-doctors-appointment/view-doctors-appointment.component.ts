import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ViewDoctorsAppointmentService } from './view-doctors-appointment.service';
import { Doctor } from '../doctor';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-view-doctors-appointment',
  templateUrl: './view-doctors-appointment.component.html',
  styleUrls: ['./view-doctors-appointment.component.scss']
})
export class ViewDoctorsAppointmentComponent implements OnInit {

  search:string; 
  constructor(private router:Router, private logout: LogoutService,private route:ActivatedRoute,private viewDocAppService:ViewDoctorsAppointmentService) { }

  ngOnInit() {
    this.route.params.subscribe(params=>this.getId(params['dId']));
    this.getAppointment();
  }
  appoinments:Doctor[];
dId:number;

getId(dId:number){
  this.dId=dId;
}
  getAppointment(){
    
    this.viewDocAppService.getDocAppoinment(this.dId)
    .subscribe((appData)=>{
      this.appoinments=appData,
      console.log(this.appoinments);
    },(error)=>{
      console.log(error);
    });
  }

   //patient Search in doctor
   searchAppointment(search: string): void{
    
    this.viewDocAppService.SearchAppointment(search,this.dId)
    .subscribe((appointmentData)=>{
      this.appoinments=appointmentData,
      console.log(appointmentData);
    }, (error) =>{
      console.log(error);
    });
  
  }

  completed()
  {
    this.viewDocAppService.getCompletedApp(this.dId).
    subscribe((appoinmentData)=>{this.appoinments=appoinmentData,
    console.log(appoinmentData);
  });
}

getAny(dId:string)
{
  this.viewDocAppService.getAnydApp(this.dId).
  subscribe((appoinmentData)=>{this.appoinments=appoinmentData,
  console.log(appoinmentData);
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
  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 


  ViewPatHis(regId:number)
  {
    this.router.navigate(['/ViewPatHis/'+this.dId+'/'+regId]);
  }
 
  
}
