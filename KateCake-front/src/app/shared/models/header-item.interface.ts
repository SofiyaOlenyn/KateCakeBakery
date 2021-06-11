import {CategoriesEnum} from '../constants/categories.constant';

export interface HeaderItemInterface {
  title: string;
  enumParam: CategoriesEnum;
  activated: boolean;
}
