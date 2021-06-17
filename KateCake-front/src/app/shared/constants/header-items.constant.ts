import {HeaderItemInterface} from '../models/header-item.interface';
import {CategoriesEnum} from './categories.constant';

export const HEADER_ITEMS: HeaderItemInterface[] = [
  {title: 'Торты', enumParam: CategoriesEnum.Cakes, activated: false},
  {title: 'Чизкейки', enumParam: CategoriesEnum.Cheesecakes, activated: false},
  {title: 'Капкейки', enumParam: CategoriesEnum.Cupcakes, activated: false},
  {title: 'Макароны', enumParam: CategoriesEnum.Macarons, activated: false},
  {title: 'Эскимо-кейкпопсы', enumParam: CategoriesEnum.Eskimo, activated: false},
];
