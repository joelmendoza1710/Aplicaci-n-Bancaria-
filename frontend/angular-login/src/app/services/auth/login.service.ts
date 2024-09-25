import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from './loginRequest';
import  {  Observable, throwError, catchError, BehaviorSubject , tap, map} from 'rxjs';
import { User } from './user';
import { environment } from 'src/environments/environment';
import { CuentaService } from '../cuentas/cuenta.service';
import { cuentaI } from '../cuentas/cuenta';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  datoslogin:any

  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  currentUserData: BehaviorSubject<String> =new BehaviorSubject<String>("");

  constructor(private http: HttpClient, private cuentaservice: CuentaService) { 
    this.currentUserLoginOn=new BehaviorSubject<boolean>(sessionStorage.getItem("token")!=null);
    this.currentUserData=new BehaviorSubject<String>(sessionStorage.getItem("token") || "");
  }
  get datoslogins(){
    return this.datoslogin
  }

  login(credentials:LoginRequest):Observable<any>{
    return this.http.post<any>(environment.urlHost+"auth/login",credentials).pipe(
      tap( (userData) => {
        sessionStorage.setItem("token", userData.token);
        this.currentUserData.next(userData.token);
        this.currentUserLoginOn.next(true);
      }),
      map((userData)=> userData.token),
      catchError(this.handleError)
    );
  }
  agregardatoslogin(login: any){
    this.datoslogin= login

  }

  deletedatoslogin(){
    this.datoslogin=undefined
  }
  register(credentials:User):Observable<any>{
    return this.http.post<any>(environment.urlHost+"auth/register",credentials).pipe(
      tap( (userData) => {
        sessionStorage.setItem("token", userData.token);
        this.currentUserData.next(userData.token);
        this.currentUserLoginOn.next(true);
        const cuentanum= 10000+1*2
        const cuenta:cuentaI={
          usuario_id:userData.result.id,
          numero_cuenta:cuentanum.toString(),
          saldo:10000000

        }
        console.log(cuenta)
        this.cuentaservice.savecuenta(cuenta).subscribe({
          next: (cuentadata)=>{
            console.log("ok cuenta creada")
          },error:(errordata)=>{
            console.log(errordata)
          }
        })

       
      }),
      map((userData)=> userData.token),
      catchError(this.handleError)
    );
  }


  logout():void{
    sessionStorage.removeItem("token");
    this.currentUserLoginOn.next(false);
  }

  private handleError(error:HttpErrorResponse){
    if(error.status===0){
      console.error('Se ha producio un error ', error.error);
    }
    else{
      console.error('Backend retornó el código de estado ', error);
    }
    return throwError(()=> new Error('Algo falló. Por favor intente nuevamente.'));
  }

  get userData():Observable<String>{
    return this.currentUserData.asObservable();
  }

  get userLoginOn(): Observable<boolean>{
    return this.currentUserLoginOn.asObservable();
  }

  get userToken():String{
    return this.currentUserData.value;
  }

}
