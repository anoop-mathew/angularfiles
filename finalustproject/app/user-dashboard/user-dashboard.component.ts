import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vendor } from '../vendor';
import { UserDashboardService } from './user-dashboard.service';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.scss']
})
export class UserDashboardComponent implements OnInit {
 users: Vendor[];
  user= new Vendor();

  constructor(private router:Router,private _viewvendor: UserDashboardService,private logout: LogoutService) { }

  ngOnInit() {
   this.getAllVendors();
  }
  getAllVendors(): void{
    this._viewvendor.getAllVendors()
    .subscribe((vendorData)=>{
      this.users=vendorData,
      console.log(vendorData);
    }, (error) =>{
      console.log(error);
    });
  }

  editVendor(vendorId:number){
    this.router.navigate(['editVendor/'+vendorId]);
  }

  disableVendor(vendorId:number):void{
    this._viewvendor.disableVendor(this.user,vendorId)
    .subscribe((response) =>{
      this. getAllVendors();
    }, (error) =>{
      console.log(error);
    });
}

searchVendor(search: string): void{
  if (search!=null){
  console.log(search);
  this._viewvendor.searchVendor(search)
  .subscribe((response)=>{
    this.users=response
    console.log(this.users);
  }, (error) =>{
    console.log(error);
    //this.getDoctors();
  });
}else{
  this.getAllVendors();
}
}

  AddVendor(){
    this.router.navigate(['/AddVendor']);   
  }
  
  Logout(){
    console.log('Logout');  
    this.logout.Logout();
  }

  Home()
  {
    this.router.navigate(['/Home']);  
  }

  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
  }

}
