�}�A  �  t�S�����e��S��u6��*�LIX7�S���ȯ�L�J��V�`�D��{b n���瀃N�,E]�i�4��s�Χ�S��h!���8�;�=���D�!Q���_([ ��:�K����j$o��'B�ytTm�_%͟��c�����30(z���o���y�YA��@���uJ�ʽ�A�XZ☹1��_Xfj������o����u`��P��w�d��G�s�c��M�t�<uJ����?��t���[t�!g@Ͳ��,?��C��B"�Iٵɔ`�;���y܍�,P޺�}C%O]�Y��0��
5u	񘾋F@m�
�Ax�\�K�5f����2K�@\��OD�����ÂQ؍��C�����Ϋ��5�;�h"�3�AjT{*�r��¬FPڳs���\�ʴ`�V/,�2_I��y���� �mX����������>�i�f@�w��DZ���g���4�� B�%�OY;i4O�:��/�/�l�,na] h��Ϋ�����5�b,ɦ����?cC�fk;��V^?�tֽ���'k����.�Ҟ��Ԑ	���7ED-C�ݑ��5�U�?���'�(�r�=9J��//��bԩXEu��ͅ ~G��孯8�.�3@o�u���}g���6}H��
>.;�\R	�nw	WL��}��G�U�Yw�7WiXoHk&��E)1轕Z�؏�_�W<�o+x]�kci9�oH*h"EV�U��r���@�E���-�Z瘕ˉ�xy���aג}�-��N!?�U&��������o]����}* ̮�2Y���l>xj'�h�����Jچ`����fB���ή�G���-�CW�0h2�٫�}�ac��9s2c�QP��_P#皒��>ƫW}�o���\�L�Ѡ��C����=� ��<s�!��=)�^��Qy��b�j
���aM�vDJL\M������T^��R�\�W?Sf��M���?c���CH�HNl�"+|�k�0Fj1��dߒ߲u%%:R����G�F�^�<���'SRj���-�b^[wPp���À	�aw@P�@�q(�eqU.B]-V*ly,Z�{��~m\�rT�Λ7؝�yw`;& ��K���k��&p:���u��	A��ܨ��לt&N�"��޽���D��fE��k��a�;�L�&�!)&]��XI�q�#�4^���Ԥ��o�����TG���zKއ����'��7k�#@��#��[lr���~�δ�3��s��=:]D�ԛt�H�䖅�"���f���$��(�)��)��@��:��E���&�2 
<�G�{߲��z�t&{kD��^}�$K)��C~�KC�Nc��/2�Th� ��A���7w��xC�Ku��y�Z�;ƆX=J�7a��V��^^Ĉ�z#�?ʏ��FV����/sOI������ܦ��ଥ��8f� }�.2P6'(@=b��=TA줅�����}`Q���3�l�%�U-���	k�I�^{Р��O��y�1��L����E#��b�r!�gV�]��a�l0��,<M��p[����Pָ{ ��Y���}�Ly�P�돔���>A���XL��n�_�S��L�f�d���(vv
�b9���<�X�D���y���{O�_�afǶ� ��#�;>v��u���r��L��T��=//O~B�ٴO��r%J!`�8�J�|[뒫O���*y��y�����R��=�_m�\��Iz�w �y��&AAq5+5:�Tqi=�C�oS���T�/�Z͇�1�D�
w��!4�u�Cbͼ����`��|y���6��ގ��?��R?6��g���"N5���Vp�,ϖ��_
J�Z����5l~̪��K�r�FZ>��x��TR�
U\�oij}f��Nb�f���u���W���8�H��
"���'������ :�����=: d�o33�t��uAB�[��-ڴ{p�=�|A������4R���u�_��T��S&o�o%f (this.compositeSubscription == null) {
            this.compositeSubscription = new CompositeSubscription();
        }

        this.compositeSubscription.add(s);
    }


    /**
     * 取消订阅
     */
    public void unSubscribe() {
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
        }
    }


}
