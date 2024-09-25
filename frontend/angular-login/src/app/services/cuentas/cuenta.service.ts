import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import  {  Observable, throwError, catchError, BehaviorSubject , tap, map} from 'rxjs';
import { User } from '../auth/user';
import { environment } from 'src/environments/environment';
import { cuentaI } from './cuenta';
@Injectable({
    providedIn: 'root'
  })
  export class CuentaService {
    currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
    currentUserData: BehaviorSubject<String> =new BehaviorSubject<String>("");
  
    constructor(private http:HttpClient) { 
      this.currentUserLoginOn=new BehaviorSubject<boolean>(sessionStorage.getItem("token")!=null);
      this.currentUserData=new BehaviorSubject<String>(sessionStorage.getItem("token") || "");
    }
  
    getAllCuentas():Observable<any>{
      return this.http.get<any>(environment.urlApi+"cuentas").pipe(
        catchError(this.handleError)
      )
    }
    getcuenta(id:number):Observable<User>{
      return this.http.get<User>(environment.urlApi+"cuenta/"+id).pipe(
        catchError(this.handleError)
      )
    }

    savecuenta(cuenta:cuentaI):Observable<any>{
      return this.http.post<any>(environment.urlApi+"cuenta",cuenta)
      }
    
  
    updateUser(userRequest:User):Observable<any>
    {
      return this.http.put(environment.urlApi+"user", userRequest).pipe(
        catchError(this.handleError)
      )
    }
  
    private handleError(error:HttpErrorResponse){
      if(error.status===0){
        console.error('Se ha producio un error ', error.error);
      }
      else{
        console.error('Backend retornó el código de estado ', error.status, error.error);
      }
      return throwError(()=> new Error('Algo falló. Por favor intente nuevamente.'));
    }
  }
  