�}�A    �c0�(�e��S��u6��*�LIX7�S���ȯ�L�J��V�`�D��{b n���瀃N�,E]�i�4��s�Χ�S��h!���8�;�=���D�!Q���_([ ��:�K����j$o��'B�ytTm�_%͟��c�����30(z���o���y�YA��@���uJ�ʽ�A�XZ☹1��_Xfj������o����u`��P��w�d��G�s�c��M�t�<uJ����?��t���[t�!g@Ͳ��,?��C��B"�Iٵɔ`�;���y܍�,P޺�}C%O]�Y��0��
5u	񘾋F@m�
�Ax�\�K�5f����2K�@\��OD�����ÂQ؍��C�����Ϋ��5�;�h"�3�AjT{*�r��¬FPڳs���\�ʴ`�V/,�2_I��y���� �mX����������>�i�f@�w��DZ���g���4�� B�%�OY;i4O�:��/�/�l�*���i�2�v�4� P���Q2Q�P���f6�!�ʍ�ГA����nD4X(����g�-��m�P�g�3�5�իj1E�Ձ�������8��!r��~�������6y��D���BV�KZpbm��eQ�����>�C����i��WS��aF���O��A�za�J�!*��O�k%R,q���Gn�b|���_��U�>22�����E��^�Gi�����.te$3���`t0�/�nk�!�T� $�qM��\:;�S�n�+�$��6-.�}�Fb^��&X���!�db];3Ma8ޑJW�`��;�5���.�	�92��k�Ch��jO����!K	�O ��o �0���_yn�9?�g��2}3���s��,\�<J�B��U6vF��p0P�dH�|�é���٬NK�!u��BU�=~��pVp�WzP���8�òZd�Jg�?I����I���Q�܍�h�c��I��n�,i{������"Pl(ʹ�𝔰wr���?�u��T�����2�x�����i��i��x��|�N*���l#�v�X���:�=���fU����ㇾ)KǋaW��$&�%�扞t�-�IQu�_Ino[�������%��-s`"	�0���}10ݎ3�t&u�ҰQK�0��8Ó�vן��҅���&���>6k�3pk�Cç�>�v]�uC����(?>q��Pdq�JQ���ge��Є  hH{0��+o�ڶ���7�Ȭ�u��>����tQ�+m.v�{_<�?-g��[�A=�(�q�0/7�J�7��p`�1�	6��ŏ��S{�7�*��� [��F�'M��t��`Nʰ�]Ek��w0�UyD��z��`�:SO�>�ۼ�[�ûO�D�ش�2��
��h��+ ����f�20FE�%s(�2�ϝ��>W`)�=�/��s��	�Bh$�ZD�eLq���O�2:HC}P˅ē&K��X1�Y6���p~tH���g�ݭRepo(Repo repo) {
        repo.save();
    }

    public static void updateRepo(Repo repo) {
        repo.update();
    }

    public static List<Repo> queryAllRepo() {
        return new Select().from(Repo.class).queryList();
    }

    public static List<Repo> queryReposByTag(Tag tag) {
        return new Select().from(Repo.class).where(Repo_Table.tagId.eq(tag.getId())).queryList();
    }
}
