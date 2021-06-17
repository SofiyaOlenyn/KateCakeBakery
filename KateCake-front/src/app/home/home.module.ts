import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {HomeComponent} from './home.component';
import {HomeRoutingModule} from './home-routing.module';
import {AssortmentComponent} from './assortment/assortment.component';
import {AboutKateComponent} from './about-kate/about-kate.component';
import {MainComponent} from './main/main.component';
import {ReviewsComponent} from './reviews/reviews.component';
import {SocialsComponent} from './socials/socials.component';
import {SharedModule} from "../shared/shared.module";


@NgModule({
  declarations: [
    HomeComponent,
    AboutKateComponent,
    AssortmentComponent,
    MainComponent,
    ReviewsComponent,
    SocialsComponent
  ],
    imports: [
        CommonModule,
        HomeRoutingModule,
        SharedModule,
    ],
  providers: []
})


export class HomeModule {
}
