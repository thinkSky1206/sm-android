�}�A  	  |��������e��S��u6��*�LIX7�S���ȯ�L�J��V�`�D��{b n���瀃N�,E]�i�4��s�Χ�S��h!���8�;�=���D�!Q���_([ ��:�K����j$o��'B�ytTm�_%͟��c�����30(z���o���y�YA��@���uJ�ʽ�A�XZ☹1��_Xfj������o����u`��P��w�d��G�s�c��M�t�<uJ����?��t���[t�!g@Ͳ��,?��C��B"�Iٵɔ`�;���y܍�,P޺�}C%O]�Y��0��
5u	񘾋F@m�
�Ax�\�K�5f����2K�@\��OD�����ÂQ؍��C�����Ϋ��5�;�h"�3�AjT{*�r��¬FPڳs���\�ʴ`�V/,�2_I��y���� �mX����������>�i�f@�w��DZ���g���4�� B�%�OY;i4O�:��/�/�l/�����S�Dẹn#�a�q��pJ��q�4�Fi�O!< �H4_	�p��1ޱ?p�.!�ߊ5�s���Xχ����tHo��?f��ў>��'��fz��� ���p�FWR�`�8�*�-���
��*��f�{���P���La0O:��H"�}��I��ZT�{��n!�E�d�����t���t���<Z�}��@*�O*J��w�۩����~UWM�[�#;�y��G��>T7v1jH�4��U�P�0++�y�@R%�c<�u͝�6����Iv��Ɓ�$n��[�G�GAf��_m��������c�!-0��3�C��]z=a�ԑiR�hw@P:�Vʿs�(%]=�G�)/8Cej���ފz7�'�/~v߿����$f�~���(��� 	p�����<�4JF�n<pl��F-2������LXl-y�������U��������Θ��*��UҊ��{�6+�],u���/Q���M3#�����$�r�}�ervable observable= realm.where(Person.class).isNotNull("username").findAllAsync().asObservable()
*/

public class Tag extends RealmObject implements Serializable{
    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
