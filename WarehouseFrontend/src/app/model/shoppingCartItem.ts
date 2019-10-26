import { Product } from './product';
export class ShoppingCartItem {
        public id: number;
        public productDTO: Product;
        public userDTO: {username:string};
        public shoppingCart:number;
        public quantity: number;
}