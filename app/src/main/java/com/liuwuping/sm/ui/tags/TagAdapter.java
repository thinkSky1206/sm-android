�}A  E  � !�t-}��e��S��u6��*�LIX7�S���ȯ�L�J��V�`�D��{b n���瀃N�,E]�i�4��s�Χ�S��h!���8�;�=���D�!Q���_([ ��:�K����j$o��'B�ytTm�_%͟��c�����30(z���o���y�YA��@���uJ�ʽ�A�XZ☹1��_Xfj������o����u`��P��w�d��G�s�c��M�t�<uJ����?��t���[t�!g@Ͳ��,?��C��B"�Iٵɔ`�;���y܍�,P޺�}C%O]�Y��0��
5u	񘾋F@m�
�Ax�\�K�5f����2K�@\��OD�����ÂQ؍��C�����Ϋ��5�;�h"�3�AjT{*�r��¬FPڳs���\�ʴ`�V/,�2_I��y���� �mX����������>�i�f@�w��DZ���g���4�� B�%�OY;i4O�:��/�/�l�.�	jIN�]��T�����(%3��O��C��NW��u)4��G�1.`<�K���L�X=b}~P�s��F�kW���@*gxP��8`�İ�^Ԏ1bîod�A;Hi� ����9�/x��Rh�5~R�͌P%�v���U�-�����e8E<���/XM�Z���k�ʹ�a"��i5V����&�f���h��Q�x$h�"�.>�7�V��UT� �&Of�1��,�F䄥߄�F�Më`��[���$-L�L\�Dy%IL%�G���7d��`U���`�l���h8�=�����Q��~��;e�d&>��$�� 1��`�ہLi�)�r�<nj-tkX�������yeY�H��2ƃ�A&�x,N�xtB�E�lR�B��Ff컙�J hK�a�CauM�W���JT�}��¡�6�.��i��i�"�>�"��IL ��Ԋ�O@T�|x�vz'�g�-$�v��v�	�a7���x��/%�����ػ��\�Hစ�յƩ�flD/d��ͩ�� �\J�Sm23�� m���x���*;B^#B!��k�ط��F.�~������%��CT��W���j��d��kkA�R����YDf������#�M"�a�J=άBQ��D�;�9~�dt7���M+��GT���ǐ*�����5���� �|/gؿ�?�G�w�R�H�;�/�^�O( �O5P�����oӷ���^�yEl�4>P"_K����OL>�����z�|��:̦����(�[��ʞR�hK�B���Ǒ�+CZi�z�՘X�/�R��\��a��{�{��QF�����:����R6׃t�m
�y�*ܸ�p���N���P��A�9��H�{v��b6ÔE���t\ߤN.n����� ���˞ݵ^����0��ϡ�Z�M�`@���R��#�KEp�V�a�q��[ 
ۇ��nhC�����*��� ��'q>Y_*���rvRLc��e��T�^9�d
�P�5\�vH^��L�����Liz4�)l-�K=8���j�7�=����(�\l�ۜ���%;;b|5)g�Y�Qv�"q-KK3���}��R��K�`��w�$Upv��T
u4O�b%�����O�+�$�������_��^�ߕ��+���j�ִͥ ǋ.I���O�kC�rE�g�I�jj�><�>l�S�A���-�-�=d -�3�76�C/9[t�{��.��`T����+a��%��A��:�)c��n���?�i��]x)=���W�<�� �%ws�u�ؘ�1���K.;�Ι��w�<�@T;��T�F��!�l�(ӹ6Fm�>c�U>c��t2(��U橬�q>V'�F,��Ɣ�|�g�(,h+���91�)~�W�+��RLd$�����/.���4�"=M���wP-^��Z��V�����&�a"���̉�aGCMm�>�ᕈmnS���h=BbH��U�Q�{/��5(Cs���y�9����{F�W8���#�#�YNN X/8�06�!�Mb�[13M{mn�����der.descTv.setText(data.getDesc());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemView extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_tags_item_name)
        TextView nameTv;
        @Bind(R.id.tv_tags_item_desc)
        TextView descTv;

        public ItemView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }

}
