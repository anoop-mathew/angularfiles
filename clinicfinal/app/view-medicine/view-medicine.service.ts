import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../admin';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViewMedicineService {
  
  constructor(private _httpService:HttpClient) { }


  getAllMedicines(): Observable<Admin[]>
  {
    return this._httpService.get<Admin[]>(environment.APIUrl+'/viewMedicineList')
  }

  disableMed(med:Admin){
    let body=JSON.stringify(med);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
    return this._httpService.put(environment.APIUrl+'/disableMedicine',body,options);
  }

  SearchMedicine(search: string): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl+'/medicineSearch/'+search);
  }
}
