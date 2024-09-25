import { Component, OnDestroy, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/auth/login.service';
import { User } from 'src/app/services/auth/user';
import { CuentaService } from 'src/app/services/cuentas/cuenta.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  userLoginOn:boolean=false;

  cuentas:any
  constructor(private loginService:LoginService,private cuentasservice:CuentaService ) { }

  ngOnInit(): void {
    this.loginService.currentUserLoginOn.subscribe({
      next:(userLoginOn) => {
        this.userLoginOn=userLoginOn;
      }
    });
    this.getallcuentas();

  }

  getallcuentas(){
    this.cuentasservice.getAllCuentas().subscribe({
      next: (cuentadata)=>{
        this.cuentas= cuentadata
        console.log(cuentadata)

      }
    })

  }

}
