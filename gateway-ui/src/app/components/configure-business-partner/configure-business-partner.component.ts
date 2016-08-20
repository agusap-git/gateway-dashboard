import { Component, OnInit } from '@angular/core';
import {BusinessPartnerService} from '../../common/services/business-partner.service';
import {IBusinessPartner} from '../../common/domain/IBusinessPartner';
import { DataTable, Column, Header, Footer, PanelMenu } from 'primeng/primeng';

@Component({
  moduleId: module.id,
  selector: 'app-configure-business-partner',
  templateUrl: 'configure-business-partner.component.html',
  directives: [ DataTable, Column, Header, Footer, PanelMenu ]
})
export class ConfigureBusinessPartnerComponent implements OnInit {

  businessPartners: IBusinessPartner[];

  constructor(private businessPartnerService: BusinessPartnerService) {
  }

  ngOnInit() {
    this.businessPartnerService.getBusinessPartners()
      .subscribe(
        data => this.businessPartners = data,
        error => alert(error),
        () => console.log(this.businessPartners)
      );
  }

}
