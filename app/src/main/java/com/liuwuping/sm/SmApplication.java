�}A  �  J�p�����e��S��u6��*�LIX7�S���ȯ�L�J��V�`�D��{b n���瀃N�,E]�i�4��s�Χ�S��h!���8�;�=���D�!Q���_([ ��:�K����j$o��'B�ytTm�_%͟��c�����30(z���o���y�YA��@���uJ�ʽ�A�XZ☹1��_Xfj������o����u`��P��w�d��G�s�c��M�t�<uJ����?��t���[t�!g@Ͳ��,?��C��B"�Iٵɔ`�;���y܍�,P޺�}C%O]�Y��0��
5u	񘾋F@m�
�Ax�\�K�5f����2K�@\��OD�����ÂQ؍��C�����Ϋ��5�;�h"�3�AjT{*�r��¬FPڳs���\�ʴ`�V/,�2_I��y���� �mX����������>�i�f@�w��DZ���g���4�� B�%�OY;i4O�:��/�/�l�-	>]XqEiA�^��ן&��'�n�]�덹L�v"�l&ې��%�����U� g�~�~+���[2^�X+���.�Mb��{7O�lYo��<A��x������z뱖+�>�fն�Hƥ�a�BO�`?��bȧ�ɯf㐫.�e�+թ���%yƆhGB��V��^��`b���3�T�w*�u�Na_��n[��M��\F�N�Ud1��>�Y<p���X���=��%����lu�g��a�{�I-�u>5&�5�IC+���ˉ^'Mִg�"��.����Tm>�~��3���r	s�$�K@��n�k�q��>����	h�������P�`��4��U�p��Q�k����,�^%]���HԎ'g�
I3�|�3X�7zUۍ����s 묖�%nx,�r���Iw��Ӊ�y׮5?�XZ�H�G�,''���m"6�idY����Ǜ�fcL��>�#<�5Ƒ�l1���LM����B7��pȼ�b�~?Mg�l�-h�����a���ohd���!��O�E��;a��:,C2���!��	(�s��'�u��
y�
-��#���^nuU#f4v�;RE�����4Myyr��}���k��Å4�kF�ʼM�.������;�莨�����"��Dc~���E����1Ǣs��Y�m��jW�r;�L�T�w%���ce�)����)�j��*yA.ƮW��H�m\�����X�=��O�{��S��fU`�|�4ؔK���>���u&�f�d�!Q��,�L15Un��9�cQ��Ѽ�wk`3ǒ=��-a��n���C`WhTe��P�vfp�(��W�**I(b�rPE�.��^9�D��\h8� c!�]���3�|Օ��3�41L �U$Ԩ����Y��h�=�J�W��)���š������X�)�2A��|� \p:�x�pH�B�[
��C���`ױ?W�~��3�b(E�2��;���m�u��G�-Tɔ��$��w��/ default shown
                .setMethodOffset(1);           // default 0
        L.init(TAG).setLogLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE);
        //sharedPref
        SharedPrefHelper.init(getApplicationContext());
        //orm
        FlowManager.init(new FlowConfig.Builder(this).build());
        //Stetho
        Stetho.initializeWithDefaults(this);
    }
}
