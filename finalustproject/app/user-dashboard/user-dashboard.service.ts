import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendor } from '../vendor';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserDashboardService {

  constructor(private _httpService:HttpClient) { }

  getAllVendors(): Observable<Vendor[]>{
    return this._httpService.get<Vendor[]>(environment.APIUrl+'/vendor');
}
   
disableVendor(disable:Vendor,vendorId:number){
  let body=JSON.stringify(disable);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

      return this._httpService.put(environment.APIUrl+'/disableVendor/'+vendorId,body,options);
    
}
searchVendor(search:string):Observable<Vendor[]>{
  return this._httpService.get<Vendor[]>(environment.APIUrl+'/vendor/'+search);
}

}