import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BookCarComponent } from './book-car/book-car.component';
import { BookBikeComponent} from  './book-bike/book-bike.component';
import { PrintCarComponent} from './print-car/print-car.component';
import { PrintBikeComponent} from './print-bike/print-bike.component';
import { PrintVehicleComponent} from './print-vehicle/print-vehicle.component';






const appRoutes: Routes = [

   
    {
        path: 'book-car',
        component: BookCarComponent,
    },
    {
        path: 'book-bike',
        component: BookBikeComponent,
    },
    {
        path: 'print-cars',
        component: PrintCarComponent,
    },
    {
        path: 'print-bikes',
        component: PrintBikeComponent,
    },
    {
        path: 'print-vehicles',
        component: PrintVehicleComponent,
    }

   
   
   
    
    
    
    
   
   
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {

}
