<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"></xsl:output>
    <xsl:template match="/Book">
        <body>
            <h1 align="center">
                <xsl:value-of select="ISBN"/>
                <xsl:text>, </xsl:text>
                <xsl:value-of select="Title"/>
            </h1>
            <h2 align="center">
                <xsl:text>by </xsl:text>
                <xsl:value-of select="Author"/>
            </h2>
            <table border="1">
                <tr>
                    <td>
                        <xsl:text>Preface </xsl:text>
                        <xsl:value-of select="Chapters/Preface/Number"/>
                    </td>
                    <td>
                        <xsl:value-of select="Chapters/Preface/Name"/>
                        <xsl:text> (</xsl:text>
                        <xsl:value-of select="Chapters/Preface/Pages"/>
                        <xsl:text> page)</xsl:text>
                    </td>
                </tr>
                <xsl:for-each select="Chapters/Chapter">
                    <xsl:sort select="Number" order="descending"></xsl:sort>
                    <tr>
                        <td>
                            Chapter
                            <xsl:value-of select="Number"/>
                        </td>
                        <td>
                            <xsl:value-of select="Name"/>
                             (<xsl:value-of select="Pages"/>
                            page)
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </xsl:template>
</xsl:stylesheet>