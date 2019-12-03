import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Admin } from '../admin';
import { AddMedicineService } from './add-medicine.service';
import { ViewMedicineService } from '../view-medicine/view-medicine.service';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-add-medicine',
  templateUrl: './add-medicine.component.html',
  styleUrls: ['./add-medicine.component.scss']
})
export class AddMedicineComponent implements OnInit {

  constructor(private router:Router,private logout: LogoutService, private _addMedicine:AddMedicineService,private route:ActivatedRoute,private _viewMedicine:ViewMedicineService){ }

  medicine=new Admin();


  ngOnInit() {

    this.route.params.subscribe( params=>this.getMedicineById(params['medId']));
  }


  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
  }


  addMedicine():void{
      this._addMedicine.addMedicine(this.medicine).subscribe((medicines)=>{
      console.log(medicines);
      this.reset();
      //this.addMedicine();
      this.router.navigate(['/ViewMedicine']);
    },(error)=>{console.log(error);});
  }
  
  private reset(){
    this.medicine.medId = null;
    this.medicine.medName = null;
    this.medicine.manufacturer=null;
    this.medicine.medPrice = null;
  }
 
getMedicineById(medId: string)
{
  console.log(medId);
  this._addMedicine.getMedicineById(medId).subscribe((medicineData)=>{
    this.medicine=medicineData;
    console.log(medicineData);
  },(error)=>{
    console.log(error);
  });
}


updateMedicine():void{
  this._addMedicine.addMedicine(this.medicine).subscribe((med)=>{
    console.log(med);
    this.router.navigate(['/ViewMedicine']);
  },(error)=>{
    console.log(error);
  });
  
}

 
  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 

  

}
