<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="State">

        <h1><xsl:value-of select="Title"/></h1>

        <table border="1">
            <tr bgcolor="#00ffff">
                <th>Name</th>
                <th>Population</th>
                <th>Capital</th>
                <th>Bird</th>
                <th>Flower</th>
                <th>Area</th>
            </tr>

            <xsl:for-each select="Datas/Data">
                <tr>
                    <td><xsl:value-of select="Name"/></td>
                    <td><xsl:value-of select="Population"/></td>
                    <td><xsl:value-of select="Capital"/></td>
                    <td><xsl:value-of select="Bird"/></td>
                    <td><xsl:value-of select="Flower"/></td>
                    <td><xsl:value-of select="Area"/></td>
                </tr>
            </xsl:for-each>
        </table>

    </xsl:template>
</xsl:stylesheet>