import {ChangeDetectionStrategy, Component, HostListener, Input, OnInit} from '@angular/core';
import {SOCIAL_LINKS} from '../constants/socials.constant';

@Component({
  selector: 'app-socials-widget',
  templateUrl: './socials-widget.component.html',
  styleUrls: ['./socials-widget.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SocialsWidgetComponent implements OnInit {
  screenWidth: number;
  @Input() showMoreInfo: boolean;

  ngOnInit(): void {
    this.screenWidth = window.innerWidth;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event): void {
    this.screenWidth = event.target.innerWidth;
  }

  getSocialLinks(): { name: string, iconPath: string, link: string }[] {
    return SOCIAL_LINKS;
  }

  openOverlay(): void {
    (document.getElementById('overlay') as HTMLElement).style.display = 'block';
  }

  closeOverlay(): void {
    (document.getElementById('overlay') as HTMLElement).style.display = 'none';
  }
}
