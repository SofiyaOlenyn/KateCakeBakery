import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';

import {HeaderComponent} from './header/header.component';
import {HeaderShrunkComponent} from './header/header-shrunk/header-shrunk.component';
import {HeaderExpandedComponent} from './header/header-expanded/header-expanded.component';
import {HeaderService} from './header/header.service';

import {DataStorageService} from './data-storage.service';

@NgModule({
  declarations: [
    HeaderComponent,
    HeaderShrunkComponent,
    HeaderExpandedComponent,
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    HeaderComponent,
    HttpClientModule,
  ],
  providers: [DataStorageService, HeaderService]
})
export class SharedModule {
}
